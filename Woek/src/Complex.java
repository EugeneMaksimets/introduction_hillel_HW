class Complex {
    private double first, second;

    public Complex(int first, int second) {
        this.first = first;
        this.second = second;
    }


    @Override
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }

        if (!(o instanceof Complex)) {
            return false;
        }

        Complex c = (Complex) o;

        return Double.compare(first, c.first) == 0
                && Double.compare(second, c.second) == 0;
    }


}