Golang
=========

Installs Go, the programming language.

This role installs Go using the method detailed in the [official install
documentation](https://go.dev/doc/install), but installs in `~/.local/lib/go`.
So, whenever the official documentation mentions `/usr/local/go`, it is replaced
with `~/.local/lib/go/current`. This avoids messing with root privileges.

In general, make this role to install the latest go version (default behavior).
If you need multiple/older versions, follow the
[Managing Go installations documentation](https://go.dev/doc/manage-install).

Uninstall go by removing the `~/.local/lib/go` directory.

Role Variables
--------------

See [defaults](default/main.yml).

License
-------

MIT

Author Information
------------------

elhub/devxp
