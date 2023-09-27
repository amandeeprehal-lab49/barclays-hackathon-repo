import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { GridReadyEvent } from 'ag-grid-community';
import { Observable, Subject, filter, map, merge, scan, switchMap, tap } from 'rxjs';
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
export class AppComponent {
  roles = [{name: 'CLIENT01'}, {name: 'CLIENT02'}, {name: 'DEALER01'}];
  roleControl = new FormControl<Role | null>(null)
  blotterData$!: Observable<Blotter[]>;

  constructor(private dataService: DataService) {
    this.blotterData$ = this.roleControl.valueChanges.pipe(
      filter((role: Role | null) => !!role),
      map((role: Role | null) => role ? role : {} as Role),
      switchMap((role: Role): Observable<Blotter[]> => {
          return merge(
              this.dataService.getBlotterData(role),
              this.dataService.listenForTradeExecutionEvents(role),
              this.dataService.listenForTradeClearingEvents(role),
              this.dataService.listenForTradeSettlementEvents(role),
          ).pipe(
              scan((acc: Blotter[], value: Blotter[] | Blotter) => 
                Array.isArray(value) ? [...acc, ...value] : [...acc, value], 
              [])
          )
      })
    )
  }

  onGridReady(gridReadyEvent: GridReadyEvent) {
  }
}
