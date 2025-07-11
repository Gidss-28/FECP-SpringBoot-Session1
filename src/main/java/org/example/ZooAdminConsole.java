package org.example;

public class ZooAdminConsole {
    private Zoo zoo;

    public ZooAdminConsole (Zoo zoo){
        this.zoo = zoo;
    }

    public void start () {
        if (zoo != null) loop();
    }

    private void loop () {

    }

    private boolean openZoo() {
        if (!this.zoo.isOpen()) {
            this.zoo.setOpen(true);
            return true;
        } else return false;
    }

    private boolean closeZoo() {
        if (this.zoo.isOpen()) {
            this.zoo.setOpen(false);
            return true;
        } else return false;
    }
}
