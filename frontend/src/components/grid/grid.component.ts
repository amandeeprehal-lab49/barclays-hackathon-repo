import { Component, EventEmitter, Input, Output } from '@angular/core';
import { ColDef, GridReadyEvent } from 'ag-grid-community';
import { Blotter } from 'src/models/blotter.model';

@Component({
  selector: 'grid-component',
  templateUrl: './grid.component.html',
  styleUrls: ['./grid.component.scss']
})
export class GridComponent {
  @Input() rowData: Partial<Blotter>[] = [];

  @Output() gridReady = new EventEmitter<GridReadyEvent>();

  defaultColDef: ColDef = {
    floatingFilter: false,
    filter: false,
    menuTabs: [],
    suppressMenu: true,
    floatingFilterComponentParams: {
      suppressFilterButton: true,
    },
  };

  colDef: ColDef<Partial<Blotter>>[] = [
    {field: 'role'},
    {field: 'tradeId'},
    {field: 'counterParty'},
    {field: 'eventDate'},
    {field: 'eventType'},
    {field: 'cdmHash'},
    {field: 'lineageHash'},
    {field: 'effectiveDate'},
    {field: 'maturityDate'},
    {field: 'dvpDate'},
    {field: 'collateral'},
    {field: 'amount'},
  ];

  onGridReady(gridReadyevent: GridReadyEvent) {
    this.gridReady.emit(gridReadyevent);
  }
}
