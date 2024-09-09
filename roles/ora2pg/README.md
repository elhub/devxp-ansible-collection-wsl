# Installs ora2pg

<https://ora2pg.darold.net/documentation.html#Installing-Ora2Pg>

ora2pg will expect a config file in `$HOME/.ora2pg/ora2pg.conf`.

# Requirements

Oracle Instantclient must be installed prior to ora2pg.

# Re-installing

To nuke all the things, run:

```
rm -rf ~/perl5/ ~/.local/lib/ora2pg/
```

Then rerun this role.

# Other notes

We are currently *not* installing the `DBD::Pg` perl module, since it requires a local install of postgreSQL.
This means that on-the-fly loading is not possible to do (which honestly does not make sense when installing locally).

> By default Ora2Pg dumps export to flat files, to load them into your PostgreSQL database you need the PostgreSQL client (psql).
> If you don't have it on the host running Ora2Pg you can always transfer these files to a host with the psql client installed.
> If you prefer to load export 'on the fly', the perl module DBD::Pg is required.