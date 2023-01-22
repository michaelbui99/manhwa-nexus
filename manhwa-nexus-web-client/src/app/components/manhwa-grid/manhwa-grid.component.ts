import { Component, Input, OnInit } from '@angular/core';
import { Manhwa } from 'src/app/models/manhwa';

@Component({
    selector: 'app-manhwa-grid',
    templateUrl: './manhwa-grid.component.html',
    styleUrls: ['./manhwa-grid.component.scss'],
})
export class ManhwaGridComponent implements OnInit {
    @Input()
    columns: number;

    @Input()
    manhwas: Manhwa[] = [];

    constructor() {}

    ngOnInit(): void {}
}
