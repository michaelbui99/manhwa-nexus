export class SimpleDate {
    year: number;
    month: number;
    day: number;

    /**
     *
     */
    constructor(year, month, day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    toString(): string {
        return `${this.year}-${this.month}-${this.day}`;
    }
}
