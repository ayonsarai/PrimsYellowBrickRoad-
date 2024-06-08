# PrimsYellowBrickRoad-

## This Java code is part of an implementation of Prim's algorithm for finding the minimum spanning tree in a graph. The graph is represented as an adjacency matrix.

## The findMinSpanningTree method is where the main logic of Prim's algorithm is implemented. It uses a priority queue pq to select the next vertex with the minimum key value. For each vertex v adjacent to the current vertex u, if v is not in the minimum spanning tree and the weight of the edge u-v is less than the key value of v, it updates the parent of v to u, the key value of v to the weight of the edge u-v, and adds v to the priority queue.

## After the minimum spanning tree is constructed, it calls the printMinSpanningTree method to print the edges of the tree and their weights. It also prints the total weight of the tree, which is the sum of the key values.

## The printMinSpanningTree method takes the parent array and the graph as parameters. It iterates over each vertex in the graph (except the first one), and for each vertex, it prints an edge from the vertex to its parent in the minimum spanning tree and the weight of the edge.
