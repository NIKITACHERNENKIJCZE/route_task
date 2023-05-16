import route_task.Path;

import java.util.*;

public class route_task_test {


    public static class Main {


        private final static String ROUTE = "Prague, Warsaw, Vilnius, Minsk, Voronezh";
        public static void main(String[] args) {
            Map<String, String> first = new HashMap<>();
            Map<String, String> second = new HashMap<>();
            StringBuilder sb = new StringBuilder();
            String current = null;

            Path[] paths = init();

            for (Path path : paths){
                first.put(path.getTo(), path.getFrom());
                second.put(path.getFrom(), path.getTo());
            }

            for (Map.Entry<String, String> entry : first.entrySet()){
                String value =  entry.getValue();
                if (!first.containsKey(value)){
                    current = value;
                    sb.append(current);
                    break;
                }
            }

            while (second.containsKey(current)){
                current = second.get(current);
                sb.append("").append(current);
            }

            String result = sb.toString();
            System.out.printf("Result ==> %s", result);
            System.out.println("Prague, Warsaw, Vilnius, Minsk, Voronezh");
            System.out.printf("Result and input string are equals? %b", result.equals(ROUTE));
        }

        private static Path[] init() {
            String [] cities = ROUTE.split("");
            List<Path> paths = new ArrayList<>();

            for (int i = 0; i < cities.length - 1; i++){
                Path path = new Path(cities[i], cities[i + 1]);
                paths.add(path);
            }

            Collections.shuffle(paths);
            Path[] array = new Path[paths.size()];
            return paths.toArray(array);
        }
    }

}
