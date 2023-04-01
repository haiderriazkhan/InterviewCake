"use strict";

// BFS based implementation to determine the shortest path between two nodes in an undirected graph
// inputs:  list of edges [[0, 5], [1,2], [3,2], [5,1], [6,3], [7]], source node, target node
function shortestPath(edgeList, sourceNodeID, targetNodeID) {
    // Get all the unique nodes in the graph
    const nodesList = new Set(edgeList.flat());
    const visited = new Array(nodesList.size).fill(false);
    const adjList = new Array(nodesList.size).fill([]);
    const distance = new Array(nodesList.size).fill(Number.MAX_SAFE_INTEGER);


    edgeList.forEach(x => {
        if (x.length > 1) {
            adjList[x[0]] = adjList[x[0]].concat(x[1]);
            adjList[x[1]] = adjList[x[1]].concat(x[0]);
        }
    });

    // start from the source node
    distance[sourceNodeID] = 0;
    visited[sourceNodeID] = true;

    const queue = [];
    queue.push(sourceNodeID);

    while(queue.length) {

        const prevNodeID = queue.shift();

        if (prevNodeID == targetNodeID) {
            return distance[targetNodeID];
        }

        adjList[prevNodeID].forEach(x => {
            if (!visited[x]) {
                queue.push(x);
                visited[x] = true;
                distance[x] = distance[prevNodeID] + 1;
            }

        })
    }
    return visited[targetNodeID] ? distance[targetNodeID] : -1;
}

const edgeList = [[1,2], [6,4], [1,3], [1,5], [2, 6], [5,3], [0]];

console.log(shortestPath(edgeList, 3, 5));
