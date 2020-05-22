# Project1-CPSC535

<ins>**Introduction:**</ins>

In this project algorithms to perform topological sorting and to compute longest path related to directed acyclic graphs (DAG) are implemented.

<ins>**Topological sorting**</ins>

The directed graph G=(V,E) is given in a text file called input.txt in which the first row contains the number of nodes N, the second row contains the # sign, and the next N rows contain the IDs of the nodes in some order, followed by a row with the # sign, followed by all the arcs. Each arc is a pair of two IDs, separated by space. Each ID is a string of maximum 8 characters. Topological sort is perfromed on the given DAG's.


<ins>**Computing Longest Path in a DAG:**</ins>

The longest path problem is the problem of finding a simple path of maximal length in a DAG, i.e. among all possible simple paths in the DAG, the problem is to find the longest one. Since we assume that the DAG is unweighted, it suffices to find the longest path in terms of the number of edges.


