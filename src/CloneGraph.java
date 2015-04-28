import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by fuliang on 2015/4/20.
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        Map<UndirectedGraphNode, UndirectedGraphNode> old2CloneMap = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        queue.offer(node);
        old2CloneMap.put(node, cloneNode);

        while (!queue.isEmpty()) {
            UndirectedGraphNode currentNode = queue.poll();
            UndirectedGraphNode currentCloneNode = old2CloneMap.get(currentNode);

            for (UndirectedGraphNode neighbor : currentNode.neighbors) {
                UndirectedGraphNode cloneNeighbor = old2CloneMap.get(neighbor);
                if (cloneNeighbor == null) {
                    cloneNeighbor = new UndirectedGraphNode(neighbor.label);
                    currentCloneNode.neighbors.add(cloneNeighbor);
                    old2CloneMap.put(neighbor, cloneNeighbor);
                    queue.offer(neighbor);
                } else {
                    currentCloneNode.neighbors.add(cloneNeighbor);
                }
            }
        }

        return cloneNode;
    }
}
