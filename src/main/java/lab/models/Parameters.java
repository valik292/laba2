package lab.models;

public class Parameters {

    double[] weights;
    double[] speeds;

    public Parameters(double[] weights, double[] speeds) {
        this.weights = weights;
        this.speeds = speeds;
    }

    public double[] getWeights() {
        return weights;
    }

    public void setWeights(double[] weights) {
        this.weights = weights;
    }

    public double[] getSpeeds() {
        return speeds;
    }

    public void setSpeeds(double[] speeds) {
        this.speeds = speeds;
    }
}