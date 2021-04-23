public class AnimalFactory {


    public static Animal getAnimalByKey(String key) {
        String animalName = null;

        if (key.equals("da") || key.equals("db") || key.equals("dc")) {

            switch (key) {
                case "da":
                    animalName = "Арамис";
                    break;
                case "db":
                    animalName = "Блек";
                    break;
                case "dc":
                    animalName = "Спайки";
                    break;
            }
            Dog dog = new Dog(animalName);
            return dog;
        } else if (key.equals("ca") || key.equals("cb") || key.equals("cc")) {
            switch (key) {
                case "ca":
                    animalName = "Арамис";
                    break;
                case "cb":
                    animalName = "Блек";
                    break;
                case "cc":
                    animalName = "Спайки";
                    break;
            }
            Cat cat = new Cat(animalName);
            return cat;

        } else {
            return null;
        }


    }

}
