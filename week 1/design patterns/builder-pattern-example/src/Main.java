// showing three different Computer builds using the builder
// the point is how readable this is compared to passing six arguments to a constructor

public class Main {

    public static void main(String[] args) {

        // only setting the required fields - optional ones use defaults
        Computer basic = new Computer.Builder("intel i3", "8gb")
                .build();

        // gaming rig - overriding all the optional fields
        Computer gaming = new Computer.Builder("intel i9", "32gb")
                .storage("2tb nvme ssd")
                .gpu("nvidia rtx 4080")
                .bluetooth(true)
                .wifi(true)
                .build();

        // workstation - needs more ram and storage but skipping gpu upgrade
        // bluetooth not needed either so explicitly setting it to false
        Computer workstation = new Computer.Builder("amd ryzen 9", "64gb")
                .storage("4tb ssd")
                .bluetooth(false)
                .build();

        System.out.println("basic build:       " + basic);
        System.out.println("gaming build:      " + gaming);
        System.out.println("workstation build: " + workstation);
    }
}
