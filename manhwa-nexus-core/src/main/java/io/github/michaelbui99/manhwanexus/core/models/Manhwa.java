package io.github.michaelbui99.manhwanexus.core.models;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Manhwa {
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
    private Map<TitleLanguage, String> alternateTitles;

    /**
     * Small synopsis / description / teaser
     */
    private String synopsis;

    /**
     * Total amount of chapters
     */
    private int chapterCount;

    /**
     * Total amount of volumes if relevant. Set to -1 if the Manhwa does not use volumnes
     */
    private int volumeCount;

    /**
     * Total amount of season if relevant. Set to -1 if the Manhwa does not use seasons
     */
    private int seasonCount;

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
    private List<String> genres;

    /**
     * Descriptive tags such as Male-Protagonist, Full-color, Anti-Hero etc.
     */
    private List<String> tags;

    /**
     * List of characters that are featured in the Manhwa
     */
    private List<Character> characters;

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
    private Map<String, String> manhwaSpecificAttributes;

    /**
     * Country code for where the Manhwa was created, e.g. KR
     */
    private CountryCode countryOfOrigin;

    /**
     * List of staff that was involved in creating the Manhwa such as artists, writers etc.
     */
    private List<Staff> staffList;

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
    private List<Manhwa> relatedManhwa;

    public Manhwa() {
    }

    public int getSeasonYear() {
        return startDate.getYear();
    }

    public Season getSeason() {
        throw new RuntimeException("Not implemented yet");
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
