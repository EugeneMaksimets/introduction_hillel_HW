

public class Test {
    static class Person implements Cloneable {
        String name;
        Car car;

        Person(Car car, String name) {
            this.car = car;

            this.name = name;
        }

        @Override
        public String toString() {
            return this.name + " {" +
                    ", car=" + car +
                    '}';
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    static class Car {
        public String color;
        public int namber;

        Car(String color, int namber) {
            this.color = color;
            this.namber = namber;

        }


        @Override
        public String toString() {
            return "{" +
                    "color car='" + color + '\'' +
                    '}';
        }

        @Override
        public int hashCode() {
            int hash;
            hash = 31 + namber;
            return hash;
        }

        @Override
        public boolean equals(Object car) {
            if (this == car) return false;
            return car instanceof Car &&
                    ((Car) car).color.equals(color);
        }
    }
}

