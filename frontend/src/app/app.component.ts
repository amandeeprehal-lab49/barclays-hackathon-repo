import { Component, OnDestroy } from '@angular/core';
import { FormControl } from '@angular/forms';
import { GridReadyEvent } from 'ag-grid-community';
import { Observable, Subject, filter, map, merge, scan, switchMap, takeUntil, tap } from 'rxjs';
import { Blotter } from 'src/models/blotter.model';
import { DataService } from 'src/services/data.service';

export interface Role {
  name: string;
}
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnDestroy {
  roles = [{name: 'CLIENT01'}, {name: 'CLIENT02'}, {name: 'DEALER01'}];
  roleControl = new FormControl<Role | null>(null)
  blotterData$!: Observable<Partial<Blotter>[]>;
  unsubscribe$ = new Subject<void>();

  constructor(private dataService: DataService) {
    this.blotterData$ = this.dataService.blotterData$.pipe(
      scan((acc: Partial<Blotter>[], value: Partial<Blotter>[] | Partial<Blotter>) => 
        Array.isArray(value) ? [...acc, ...value] : [...acc, value], 
      []),
    );

    this.roleControl.valueChanges.pipe(
      filter((role: Role | null) => !!role),
      map((role: Role | null) => role ? role : {} as Role),
      // switchMap((role: Role): Observable<Blotter[]> => {
          // return merge(
              // this.dataService.getBlotterData(role),
              // return this.dataService.listenForTradeEvents(role)
              // this.dataService.listenForTradeClearingEvents(role),
              // this.dataService.listenForTradeSettlementEvents(role),
          // )
          // .pipe(
          //     scan((acc: Blotter[], value: Blotter[] | Blotter) => 
          //       Array.isArray(value) ? [...acc, ...value] : [...acc, value], 
          //     [])
          // )
      // }),
      takeUntil(this.unsubscribe$),
    ).subscribe((role: Role) => {
      this.dataService.listenForTradeEvents(role);
    });
  }

  ngOnDestroy(): void {
      this.unsubscribe$.next();
      this.unsubscribe$.complete();
  }

  onGridReady(gridReadyEvent: GridReadyEvent) {
  }
}
