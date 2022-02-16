import graphviz
from graphviz import Digraph

inp = open("3_out.txt")

#Child PIDS; Parent PIDS
processes = inp.read()

processList = processes.split("\n")
processList = list(filter(None,processList))
del processList[len(processList)-1] #Takes care of unintended system fork

forksProcessTree = Digraph(comment="Process Tree")

for i in processList:
    PID = i.split(" ; ")[0]
    PPID = i.split(" ; ")[1]
    
    forksProcessTree.node(PID, "PID: " + PID)
    forksProcessTree.node(PPID, "PID: " + PPID)
    forksProcessTree.edge(i.split(" ; ")[1], PID)

forksProcessTree.render("3_processTree.gv", view=True)
