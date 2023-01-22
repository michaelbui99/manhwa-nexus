import { Component, OnInit } from '@angular/core';
import { Manhwa } from 'src/app/models/manhwa';
import { ManhwaService } from 'src/app/services/http/manhwa.service';

@Component({
    selector: 'app-browse',
    templateUrl: './browse.component.html',
    styleUrls: ['./browse.component.scss'],
})
export class BrowseComponent implements OnInit {
    manhwas: Manhwa[] = [];
    genres: string[] = [];

    constructor(private _manhwaService: ManhwaService) {}

    async ngOnInit(): Promise<void> {
        this.manhwas = await this._manhwaService.getManhwas();
        this.genres = await this._manhwaService.getGenres();
    }
}
