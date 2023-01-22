import { Component, OnInit } from '@angular/core';
import { ManhwaService } from 'src/app/services/http/manhwa-service.service';

@Component({
    selector: 'app-browse',
    templateUrl: './browse.component.html',
    styleUrls: ['./browse.component.scss'],
})
export class BrowseComponent implements OnInit {
    constructor(private _manhwaService: ManhwaService) {}

    async ngOnInit(): Promise<void> {
        const manhwas = await this._manhwaService.getManhwas();
        console.log(manhwas);
    }
}
