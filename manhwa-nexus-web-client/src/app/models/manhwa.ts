export interface Manhwa {
    id: number;
    title: string;
    alternateTitles?: Map<string, string>;
    synopsis?: string;
    chapterCount: number;
    volumeCount: number;
    seasonCount: number;
    startDate?: Date;
    endDate?: Date;
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
}
