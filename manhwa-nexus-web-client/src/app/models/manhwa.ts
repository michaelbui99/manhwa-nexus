import { SimpleDate } from './simple-date';

export interface Manhwa {
    id: number;
    title: string;
    alternateTitles?: Map<string, string>;
    synopsis?: string;
    chapterCount: number;
    volumeCount: number;
    seasonCount: number;
    startDate?: SimpleDate;
    endDate?: SimpleDate;
    isAdult: boolean;
    genres: string[];
    tags?: string[];
    characters?: object[];
    staffList?: object[];
    publisher?: object;
    studio?: object;
    sourceMaterial: string;
    countryOfOrigin: string;
    relatedManhwa: object[];
    coverUrl: string;
    status: string;
}
