package io.github.michaelbui.manhwanexus.dataaccess.repositories;

import io.github.michaelbui.manhwanexus.dataaccess.ConnectionProvider;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

public class BaseJooqRepository {
    private final ConnectionProvider connectionProvider = ConnectionProvider.getInstance();

    public DSLContext getDSLContext() {
        return DSL.using(connectionProvider.getConnection(), SQLDialect.POSTGRES);
    }
}
