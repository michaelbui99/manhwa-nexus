package io.github.michaelbui99.manhwanexus.core.models;

import io.github.michaelbui99.manhwanexus.core.ReadonlyPair;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManhwaBuilder {
    /**
     * Internal id
     */
    private int id;
    /**
     * Title of the Manhwa, e.g. Solo Leveling
     */
    private String title;

    /**
     * Alternate titles such as Korean title or Japanese title
     */
    private Map<TitleLanguage, String> alternateTitles = new HashMap<>();

    /**
     * Small synopsis / description / teaser
     */
    private String synopsis = "";

    /**
     * Total amount of chapters
     */
    private int chapterCount = 0;

    /**
     * Total amount of volumes if relevant. Set to -1 if the Manhwa does not use volumnes
     */
    private int volumeCount = 0;

    /**
     * Total amount of season if relevant. Set to -1 if the Manhwa does not use seasons
     */
    private int seasonCount = 0;

    /**
     * First chapter release date
     */
    private LocalDate startDate;

    /**
     * Last chapter release date
     */
    private LocalDate endDate;

    /**
     * True if intended audience is 18+
     */
    private boolean isAdult;

    /**
     * Genres such as Romance, Action, Comedy etc.
     */
    private List<String> genres = new ArrayList<>();

    /**
     * Descriptive tags such as Male-Protagonist, Full-color, Anti-Hero etc.
     */
    private List<String> tags = new ArrayList<>();

    /**
     * List of characters that are featured in the Manhwa
     */
    private List<Character> characters = new ArrayList<>();

    /**
     * Source that the Manhwa is based on, e.g. Web Novel or Original
     */
    private Source sourceMaterial;

    /**
     * Manhwa-specific attributes.
     * Key = Attribute name
     * Value = Content
     * e.g. "Weapon(s)" : "BF Sword"
     */
    private Map<String, String> manhwaSpecificAttributes = new HashMap<>();

    /**
     * Country code for where the Manhwa was created, e.g. KR
     */
    private CountryCode countryOfOrigin;

    /**
     * List of staff that was involved in creating the Manhwa such as artists, writers etc.
     */
    private List<Staff> staffList = new ArrayList<>();

    /**
     * Studio that created the Manhwa
     */
    private Studio studio;

    /**
     * Publisher of the Manhwa
     */
    private Publisher publisher;

    /**
     * Related manhwa such as manhwas in the same series e.g. The Breaker is related to The Breaker: New Waves
     */
    private List<Manhwa> relatedManhwa = new ArrayList<>();

    public ManhwaBuilder(int id, String title, List<String> genres, Source sourceMaterial, CountryCode countryOfOrigin) {
        this.id = id;
        this.title = title;
        this.genres = genres;
        this.sourceMaterial = sourceMaterial;
        this.countryOfOrigin = countryOfOrigin;
    }

    public Manhwa build() {
        return new Manhwa(this);
    }

    public ManhwaBuilder alternateTitles(ReadonlyPair<TitleLanguage, String>... titles) {
        for (ReadonlyPair<TitleLanguage, String> pair : titles) {
            alternateTitles.put(pair.key(), pair.value());
        }

        return this;
    }

    public ManhwaBuilder synopsis(String synopsis) {
        this.synopsis = synopsis;
        return this;
    }

    public ManhwaBuilder chapterCount(int count) {
        this.chapterCount = count;
        return this;
    }

    public ManhwaBuilder volumeCount(int count) {
        this.volumeCount = count;
        return this;
    }

    public ManhwaBuilder seasonCount(int count) {
        this.seasonCount = count;
        return this;
    }

    public ManhwaBuilder startDate(LocalDate date) {
        this.startDate = date;
        return this;
    }

    public ManhwaBuilder endDate(LocalDate date) {
        this.endDate = date;
        return this;
    }

    public ManhwaBuilder isAdult(boolean isAdult) {
        this.isAdult = isAdult;
        return this;
    }

    public ManhwaBuilder tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public ManhwaBuilder characters(List<Character> characters) {
        this.characters = characters;
        return this;
    }

    public ManhwaBuilder staffList(List<Staff> staffList) {
        this.staffList = staffList;
        return this;
    }

    public ManhwaBuilder studio(Studio studio) {
        this.studio = studio;
        return this;
    }

    public ManhwaBuilder publisher(Publisher publisher) {
        this.publisher = publisher;
        return this;
    }

    public ManhwaBuilder relatedManhwas(List<Manhwa> manhwas){
        this.relatedManhwa = manhwas;
        return this;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Map<TitleLanguage, String> getAlternateTitles() {
        return alternateTitles;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public int getChapterCount() {
        return chapterCount;
    }

    public int getVolumeCount() {
        return volumeCount;
    }

    public int getSeasonCount() {
        return seasonCount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public List<String> getGenres() {
        return genres;
    }

    public List<String> getTags() {
        return tags;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public Source getSourceMaterial() {
        return sourceMaterial;
    }

    public Map<String, String> getManhwaSpecificAttributes() {
        return manhwaSpecificAttributes;
    }

    public CountryCode getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    public Studio getStudio() {
        return studio;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public List<Manhwa> getRelatedManhwa() {
        return relatedManhwa;
    }
}
