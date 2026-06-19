// builder pattern

public class Computer {

    private String cpu;
    private String ram;
    private String storage;
    private String gpu;
    private boolean hasBluetooth;
    private boolean hasWifi;

    private Computer(Builder builder) {
        this.cpu          = builder.cpu;
        this.ram          = builder.ram;
        this.storage      = builder.storage;
        this.gpu          = builder.gpu;
        this.hasBluetooth = builder.hasBluetooth;
        this.hasWifi      = builder.hasWifi;
    }

    public String toString() {
        return "cpu=" + cpu + " | ram=" + ram + " | storage=" + storage
             + " | gpu=" + gpu + " | bluetooth=" + hasBluetooth + " | wifi=" + hasWifi;
    }

    public static class Builder {

        private String cpu;
        private String ram;

        private String storage       = "256gb ssd";
        private String gpu           = "integrated";
        private boolean hasBluetooth = false;
        private boolean hasWifi      = true;

        public Builder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        public Builder storage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder gpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Builder bluetooth(boolean val) {
            this.hasBluetooth = val;
            return this;
        }

        public Builder wifi(boolean val) {
            this.hasWifi = val;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
