import { Component, Input, OnInit } from '@angular/core';
import { Manhwa } from 'src/app/models/manhwa';

@Component({
    selector: 'app-manhwa-card',
    templateUrl: './manhwa-card.component.html',
    styleUrls: ['./manhwa-card.component.scss'],
})
export class ManhwaCardComponent implements OnInit {
    @Input()
    manhwa: Manhwa;

    hover: boolean = false;

    constructor() {}

    ngOnInit(): void {
        console.log(this.manhwa);
    }

    onMouseEnter() {
        this.hover = true;
    }

    onMouseLeave() {
        this.hover = false;
    }
}
