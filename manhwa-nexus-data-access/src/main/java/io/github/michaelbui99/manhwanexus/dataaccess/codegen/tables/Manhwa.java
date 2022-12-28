/*
 * This file is generated by jOOQ.
 */
package io.github.michaelbui99.manhwanexus.dataaccess.codegen.tables;


import io.github.michaelbui99.manhwanexus.dataaccess.codegen.Keys;
import io.github.michaelbui99.manhwanexus.dataaccess.codegen.ManhwaNexus;
import io.github.michaelbui99.manhwanexus.dataaccess.codegen.tables.records.ManhwaRecord;

import java.time.LocalDate;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function9;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row9;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Manhwa extends TableImpl<ManhwaRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>manhwa_nexus.manhwa</code>
     */
    public static final Manhwa MANHWA = new Manhwa();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ManhwaRecord> getRecordType() {
        return ManhwaRecord.class;
    }

    /**
     * The column <code>manhwa_nexus.manhwa.id</code>.
     */
    public final TableField<ManhwaRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>manhwa_nexus.manhwa.title</code>.
     */
    public final TableField<ManhwaRecord, String> TITLE = createField(DSL.name("title"), SQLDataType.VARCHAR(200).nullable(false), this, "");

    /**
     * The column <code>manhwa_nexus.manhwa.synopsis</code>.
     */
    public final TableField<ManhwaRecord, String> SYNOPSIS = createField(DSL.name("synopsis"), SQLDataType.VARCHAR(2000), this, "");

    /**
     * The column <code>manhwa_nexus.manhwa.chapter_count</code>.
     */
    public final TableField<ManhwaRecord, Integer> CHAPTER_COUNT = createField(DSL.name("chapter_count"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>manhwa_nexus.manhwa.volume_count</code>.
     */
    public final TableField<ManhwaRecord, Integer> VOLUME_COUNT = createField(DSL.name("volume_count"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>manhwa_nexus.manhwa.season_count</code>.
     */
    public final TableField<ManhwaRecord, Integer> SEASON_COUNT = createField(DSL.name("season_count"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>manhwa_nexus.manhwa.start_date</code>.
     */
    public final TableField<ManhwaRecord, LocalDate> START_DATE = createField(DSL.name("start_date"), SQLDataType.LOCALDATE, this, "");

    /**
     * The column <code>manhwa_nexus.manhwa.end_date</code>.
     */
    public final TableField<ManhwaRecord, LocalDate> END_DATE = createField(DSL.name("end_date"), SQLDataType.LOCALDATE, this, "");

    /**
     * The column <code>manhwa_nexus.manhwa.is_adult</code>.
     */
    public final TableField<ManhwaRecord, Boolean> IS_ADULT = createField(DSL.name("is_adult"), SQLDataType.BOOLEAN, this, "");

    private Manhwa(Name alias, Table<ManhwaRecord> aliased) {
        this(alias, aliased, null);
    }

    private Manhwa(Name alias, Table<ManhwaRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>manhwa_nexus.manhwa</code> table reference
     */
    public Manhwa(String alias) {
        this(DSL.name(alias), MANHWA);
    }

    /**
     * Create an aliased <code>manhwa_nexus.manhwa</code> table reference
     */
    public Manhwa(Name alias) {
        this(alias, MANHWA);
    }

    /**
     * Create a <code>manhwa_nexus.manhwa</code> table reference
     */
    public Manhwa() {
        this(DSL.name("manhwa"), null);
    }

    public <O extends Record> Manhwa(Table<O> child, ForeignKey<O, ManhwaRecord> key) {
        super(child, key, MANHWA);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : ManhwaNexus.MANHWA_NEXUS;
    }

    @Override
    public Identity<ManhwaRecord, Integer> getIdentity() {
        return (Identity<ManhwaRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<ManhwaRecord> getPrimaryKey() {
        return Keys.MANHWA_PKEY;
    }

    @Override
    public Manhwa as(String alias) {
        return new Manhwa(DSL.name(alias), this);
    }

    @Override
    public Manhwa as(Name alias) {
        return new Manhwa(alias, this);
    }

    @Override
    public Manhwa as(Table<?> alias) {
        return new Manhwa(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Manhwa rename(String name) {
        return new Manhwa(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Manhwa rename(Name name) {
        return new Manhwa(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Manhwa rename(Table<?> name) {
        return new Manhwa(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row9<Integer, String, String, Integer, Integer, Integer, LocalDate, LocalDate, Boolean> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function9<? super Integer, ? super String, ? super String, ? super Integer, ? super Integer, ? super Integer, ? super LocalDate, ? super LocalDate, ? super Boolean, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function9<? super Integer, ? super String, ? super String, ? super Integer, ? super Integer, ? super Integer, ? super LocalDate, ? super LocalDate, ? super Boolean, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
