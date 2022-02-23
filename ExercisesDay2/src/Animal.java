import java.util.List;

public class Animal {
        String name;
        boolean canRun;
        boolean canSwim;

        public Animal(String name, boolean runner, boolean swimmer){
            this.name = name;
            this.canRun = runner;
            this.canSwim = swimmer;
        }

        public boolean isRunner(){
            return canRun;
        }

        public boolean isSwimmer(){
            return canSwim;
        }

        @Override
        public String toString(){
            return name;
        }

    }

