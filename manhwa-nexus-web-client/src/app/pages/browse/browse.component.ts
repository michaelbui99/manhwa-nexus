import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
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
    selectedGenre: string;
    manhwasToShow: Manhwa[] = this.manhwas;

    constructor(private _manhwaService: ManhwaService, private _snackBar: MatSnackBar) {}

    async ngOnInit(): Promise<void> {
        try {
            this.manhwas = await this._manhwaService.getManhwas();
            this.manhwasToShow = this.manhwas;
            this.genres = await this._manhwaService.getGenres();
        } catch (err) {
            console.error(err);
            this._snackBar.open('Connection to server lost...', null, {
                duration: 8000,
            });
        }
    }

    filterManhwas() {
        this.manhwasToShow = this.manhwas;

        if (this.selectedGenre) {
            this.manhwasToShow = this.manhwas.filter((manhwa) =>
                manhwa.genres.includes(this.selectedGenre)
            );
        }
    }
}
