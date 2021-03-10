import graphviz
from graphviz import Digraph

inp = open("out.txt")

#Child PIDS; Parent PIDS
processes = inp.read()

processList = processes.split("\n")
processList = list(filter(None,processList))
del processList[0] #Takes care of unintended system fork

forksProcessTree = Digraph(comment="Process Tree")

for i in processList:
    PID = i.split(" ; ")[0]
    PPID = i.split(" ; ")[1]
    
    forksProcessTree.node(PID, "PID: " + PID)
    forksProcessTree.node(PPID, "PID: " + PPID)
    forksProcessTree.edge(i.split(" ; ")[1], PID)

forksProcessTree.render("processTree.gv", view=True)
