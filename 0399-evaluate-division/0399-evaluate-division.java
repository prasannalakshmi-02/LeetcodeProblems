class Solution {
    private Map<String, Map<String, Double>> graph = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {  
         for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0); 
            String v = equations.get(i).get(1); 
            double val = values[i];

            graph.putIfAbsent(u, new HashMap<>());
            graph.get(u).put(v, val);

            graph.putIfAbsent(v, new HashMap<>());
            graph.get(v).put(u, 1.0 / val);
         }

        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                results[i] = -1.0;
            } else {
                results[i] = dfs(start, end, new HashSet<>());
            }
        }
        
        return results;
    }

    private double dfs(String current, String target, Set<String> visited) {

        if (current.equals(target)) {
            return 1.0;
        }

        visited.add(current);
        if (graph.containsKey(current)) {
            for (Map.Entry<String, Double> neighborEntry : graph.get(current).entrySet()) {
                String neighbor = neighborEntry.getKey();
                double weight = neighborEntry.getValue();

                if (!visited.contains(neighbor)) {
        
                    double result = dfs(neighbor, target, visited);
                    
                    if (result != -1.0) {
                        return weight * result; 
                    }
                }
            }
        }

        return -1.0;
    }
}