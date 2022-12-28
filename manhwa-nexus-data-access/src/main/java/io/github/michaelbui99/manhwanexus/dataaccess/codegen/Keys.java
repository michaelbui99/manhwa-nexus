/*
 * This file is generated by jOOQ.
 */
package io.github.michaelbui99.manhwanexus.dataaccess.codegen;


import io.github.michaelbui99.manhwanexus.dataaccess.codegen.tables.AlternateTitle;
import io.github.michaelbui99.manhwanexus.dataaccess.codegen.tables.Genre;
import io.github.michaelbui99.manhwanexus.dataaccess.codegen.tables.Manhwa;
import io.github.michaelbui99.manhwanexus.dataaccess.codegen.tables.ManhwaGenre;
import io.github.michaelbui99.manhwanexus.dataaccess.codegen.tables.ManhwaTag;
import io.github.michaelbui99.manhwanexus.dataaccess.codegen.tables.RelatedManhwa;
import io.github.michaelbui99.manhwanexus.dataaccess.codegen.tables.Tag;
import io.github.michaelbui99.manhwanexus.dataaccess.codegen.tables.TitleLanguage;
import io.github.michaelbui99.manhwanexus.dataaccess.codegen.tables.records.AlternateTitleRecord;
import io.github.michaelbui99.manhwanexus.dataaccess.codegen.tables.records.GenreRecord;
import io.github.michaelbui99.manhwanexus.dataaccess.codegen.tables.records.ManhwaGenreRecord;
import io.github.michaelbui99.manhwanexus.dataaccess.codegen.tables.records.ManhwaRecord;
import io.github.michaelbui99.manhwanexus.dataaccess.codegen.tables.records.ManhwaTagRecord;
import io.github.michaelbui99.manhwanexus.dataaccess.codegen.tables.records.RelatedManhwaRecord;
import io.github.michaelbui99.manhwanexus.dataaccess.codegen.tables.records.TagRecord;
import io.github.michaelbui99.manhwanexus.dataaccess.codegen.tables.records.TitleLanguageRecord;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * manhwa_nexus.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AlternateTitleRecord> ALTERNATE_TITLE_PKEY = Internal.createUniqueKey(AlternateTitle.ALTERNATE_TITLE, DSL.name("alternate_title_pkey"), new TableField[] { AlternateTitle.ALTERNATE_TITLE.ID }, true);
    public static final UniqueKey<GenreRecord> GENRE_PKEY = Internal.createUniqueKey(Genre.GENRE, DSL.name("genre_pkey"), new TableField[] { Genre.GENRE.ID }, true);
    public static final UniqueKey<ManhwaRecord> MANHWA_PKEY = Internal.createUniqueKey(Manhwa.MANHWA, DSL.name("manhwa_pkey"), new TableField[] { Manhwa.MANHWA.ID }, true);
    public static final UniqueKey<ManhwaGenreRecord> MANHWA_GENRE_PKEY = Internal.createUniqueKey(ManhwaGenre.MANHWA_GENRE, DSL.name("manhwa_genre_pkey"), new TableField[] { ManhwaGenre.MANHWA_GENRE.MANHWA_ID, ManhwaGenre.MANHWA_GENRE.GENRE_ID }, true);
    public static final UniqueKey<ManhwaTagRecord> MANHWA_TAG_PKEY = Internal.createUniqueKey(ManhwaTag.MANHWA_TAG, DSL.name("manhwa_tag_pkey"), new TableField[] { ManhwaTag.MANHWA_TAG.MANHWA_ID, ManhwaTag.MANHWA_TAG.TAG_ID }, true);
    public static final UniqueKey<RelatedManhwaRecord> RELATED_MANHWA_PKEY = Internal.createUniqueKey(RelatedManhwa.RELATED_MANHWA, DSL.name("related_manhwa_pkey"), new TableField[] { RelatedManhwa.RELATED_MANHWA.MANHWA1_ID, RelatedManhwa.RELATED_MANHWA.MANHWA2_ID }, true);
    public static final UniqueKey<TagRecord> TAG_PKEY = Internal.createUniqueKey(Tag.TAG, DSL.name("tag_pkey"), new TableField[] { Tag.TAG.ID }, true);
    public static final UniqueKey<TitleLanguageRecord> TITLE_LANGUAGE_PKEY = Internal.createUniqueKey(TitleLanguage.TITLE_LANGUAGE, DSL.name("title_language_pkey"), new TableField[] { TitleLanguage.TITLE_LANGUAGE.ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<AlternateTitleRecord, ManhwaRecord> ALTERNATE_TITLE__ALTERNATE_TITLE_MANHWA_ID_FKEY = Internal.createForeignKey(AlternateTitle.ALTERNATE_TITLE, DSL.name("alternate_title_manhwa_id_fkey"), new TableField[] { AlternateTitle.ALTERNATE_TITLE.MANHWA_ID }, Keys.MANHWA_PKEY, new TableField[] { Manhwa.MANHWA.ID }, true);
    public static final ForeignKey<AlternateTitleRecord, TitleLanguageRecord> ALTERNATE_TITLE__ALTERNATE_TITLE_TITLE_LANGUAGE_ID_FKEY = Internal.createForeignKey(AlternateTitle.ALTERNATE_TITLE, DSL.name("alternate_title_title_language_id_fkey"), new TableField[] { AlternateTitle.ALTERNATE_TITLE.TITLE_LANGUAGE_ID }, Keys.TITLE_LANGUAGE_PKEY, new TableField[] { TitleLanguage.TITLE_LANGUAGE.ID }, true);
    public static final ForeignKey<ManhwaGenreRecord, GenreRecord> MANHWA_GENRE__MANHWA_GENRE_GENRE_ID_FKEY = Internal.createForeignKey(ManhwaGenre.MANHWA_GENRE, DSL.name("manhwa_genre_genre_id_fkey"), new TableField[] { ManhwaGenre.MANHWA_GENRE.GENRE_ID }, Keys.GENRE_PKEY, new TableField[] { Genre.GENRE.ID }, true);
    public static final ForeignKey<ManhwaGenreRecord, ManhwaRecord> MANHWA_GENRE__MANHWA_GENRE_MANHWA_ID_FKEY = Internal.createForeignKey(ManhwaGenre.MANHWA_GENRE, DSL.name("manhwa_genre_manhwa_id_fkey"), new TableField[] { ManhwaGenre.MANHWA_GENRE.MANHWA_ID }, Keys.MANHWA_PKEY, new TableField[] { Manhwa.MANHWA.ID }, true);
    public static final ForeignKey<ManhwaTagRecord, ManhwaRecord> MANHWA_TAG__MANHWA_TAG_MANHWA_ID_FKEY = Internal.createForeignKey(ManhwaTag.MANHWA_TAG, DSL.name("manhwa_tag_manhwa_id_fkey"), new TableField[] { ManhwaTag.MANHWA_TAG.MANHWA_ID }, Keys.MANHWA_PKEY, new TableField[] { Manhwa.MANHWA.ID }, true);
    public static final ForeignKey<ManhwaTagRecord, TagRecord> MANHWA_TAG__MANHWA_TAG_TAG_ID_FKEY = Internal.createForeignKey(ManhwaTag.MANHWA_TAG, DSL.name("manhwa_tag_tag_id_fkey"), new TableField[] { ManhwaTag.MANHWA_TAG.TAG_ID }, Keys.TAG_PKEY, new TableField[] { Tag.TAG.ID }, true);
    public static final ForeignKey<RelatedManhwaRecord, ManhwaRecord> RELATED_MANHWA__RELATED_MANHWA_MANHWA1_ID_FKEY = Internal.createForeignKey(RelatedManhwa.RELATED_MANHWA, DSL.name("related_manhwa_manhwa1_id_fkey"), new TableField[] { RelatedManhwa.RELATED_MANHWA.MANHWA1_ID }, Keys.MANHWA_PKEY, new TableField[] { Manhwa.MANHWA.ID }, true);
    public static final ForeignKey<RelatedManhwaRecord, ManhwaRecord> RELATED_MANHWA__RELATED_MANHWA_MANHWA2_ID_FKEY = Internal.createForeignKey(RelatedManhwa.RELATED_MANHWA, DSL.name("related_manhwa_manhwa2_id_fkey"), new TableField[] { RelatedManhwa.RELATED_MANHWA.MANHWA2_ID }, Keys.MANHWA_PKEY, new TableField[] { Manhwa.MANHWA.ID }, true);
}
