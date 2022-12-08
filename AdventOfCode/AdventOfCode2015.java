package AdventOfCode;

import java.util.ArrayList;
import java.util.List;

import static AdventOfCode.ReadInput.readAOC201509;

public class AdventOfCode2015 {

    public static void main(String[] args)
    {
        List<String> input = readAOC201509();
    }

    public static void getGraph( List<String> input)
    {

    }

    public class Node{
        String source;
        String destination;
        int distance;

        public Node(String source, String destination, int distance) {
            this.source = source;
            this.destination = destination;
            this.distance = distance;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }
    }
}


