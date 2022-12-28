/*
 * This file is generated by jOOQ.
 */
package io.github.michaelbui99.manhwanexus.dataaccess.codegen.tables;


import io.github.michaelbui99.manhwanexus.dataaccess.codegen.Keys;
import io.github.michaelbui99.manhwanexus.dataaccess.codegen.ManhwaNexus;
import io.github.michaelbui99.manhwanexus.dataaccess.codegen.tables.records.GenreRecord;

import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function2;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row2;
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
public class Genre extends TableImpl<GenreRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>manhwa_nexus.genre</code>
     */
    public static final Genre GENRE = new Genre();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GenreRecord> getRecordType() {
        return GenreRecord.class;
    }

    /**
     * The column <code>manhwa_nexus.genre.id</code>.
     */
    public final TableField<GenreRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>manhwa_nexus.genre.genre</code>.
     */
    public final TableField<GenreRecord, String> GENRE_ = createField(DSL.name("genre"), SQLDataType.VARCHAR(50), this, "");

    private Genre(Name alias, Table<GenreRecord> aliased) {
        this(alias, aliased, null);
    }

    private Genre(Name alias, Table<GenreRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>manhwa_nexus.genre</code> table reference
     */
    public Genre(String alias) {
        this(DSL.name(alias), GENRE);
    }

    /**
     * Create an aliased <code>manhwa_nexus.genre</code> table reference
     */
    public Genre(Name alias) {
        this(alias, GENRE);
    }

    /**
     * Create a <code>manhwa_nexus.genre</code> table reference
     */
    public Genre() {
        this(DSL.name("genre"), null);
    }

    public <O extends Record> Genre(Table<O> child, ForeignKey<O, GenreRecord> key) {
        super(child, key, GENRE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : ManhwaNexus.MANHWA_NEXUS;
    }

    @Override
    public Identity<GenreRecord, Integer> getIdentity() {
        return (Identity<GenreRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<GenreRecord> getPrimaryKey() {
        return Keys.GENRE_PKEY;
    }

    @Override
    public Genre as(String alias) {
        return new Genre(DSL.name(alias), this);
    }

    @Override
    public Genre as(Name alias) {
        return new Genre(alias, this);
    }

    @Override
    public Genre as(Table<?> alias) {
        return new Genre(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Genre rename(String name) {
        return new Genre(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Genre rename(Name name) {
        return new Genre(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Genre rename(Table<?> name) {
        return new Genre(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function2<? super Integer, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function2<? super Integer, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
