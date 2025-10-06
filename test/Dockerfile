FROM ubuntu:noble

RUN apt-get update \
    && apt-get -y install sudo

RUN \
    groupadd -g 999 foo && useradd -u 999 -g foo -G sudo -m -s /bin/bash foo && \
    sed -i /etc/sudoers -re 's/^%sudo.*/%sudo ALL=(ALL:ALL) NOPASSWD: ALL/g' && \
    sed -i /etc/sudoers -re 's/^root.*/root ALL=(ALL:ALL) NOPASSWD: ALL/g' && \
    sed -i /etc/sudoers -re 's/^#includedir.*/## **Removed the include directive** ##"/g' && \
    echo "foo ALL=(ALL) NOPASSWD: ALL" >> /etc/sudoers && \
    echo "Customized the sudoers file for passwordless access to the foo user!" && \
    echo "foo user:";  su - foo -c id

USER foo

WORKDIR '/home/foo/devxp-ansible-collection-wsl/'

CMD ["/bin/bash"]

COPY . .

COPY roles test/.

RUN sudo chown -R foo:foo ~/devxp-ansible-collection-wsl

RUN \
    sudo apt update && \
    sudo apt-get -y dist-upgrade && \
    sudo apt install -y git python3 python3-pip && \
    sudo apt remove -y ansible && \
    sudo apt autoremove -y && \
    python3 -m pip install --user ansible

# Run roles via test playbook
RUN \
    . ~/.profile && \
    export PATH="$PATH":/home/foo/.local/bin && \
    ansible-playbook test/test.yml
