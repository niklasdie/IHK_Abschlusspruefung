Diese Anwendung ist auf Linux (Debian) und mit Java Corretto 17.0.6 entwickelt und getestet worden.
Daher ist die Lauffähigkeit des Programms ausschließlich auf dieser Plattform garantiert.
Es muss dieses Java auf dem Rechner installiert sein zum Ausführen des Programms.

Normalerweise sollte das Programm ebenfalls auf Windows oder mit anderen Java 17 oder neueren Java Versionen funktionieren.

Die Anwendung kann geöffnet werden, indem man im Terminal den folgenden Command eingibt:

`bash <pathTo>/run_gro_pro.sh -input <pathToInputFile> -output <pathToOutputFile> (-log [true, false, file]) (-loglvl [info, warning]) (-help)`

Die `<>`-Elemente müssen ersetzt werden, wobei `()`-Elemente optional sind.
`[]`-Elemente beschreiben vorhandene Auswahlmöglichkeit.

* -input {"Pfad der Eingabedatei"} 
* -output {"Pfad der Ausgabedatei"}
* -log {"true", "false" oder "file"}, default: "false"
* -loglvl {"info" oder "warning"}, default: "all"

Die Argumente "-input" und "-output" sowie der zugehörige Dateipfad müssen vorhanden sein. 
Der Rest der Argumente kann benutzt werden, muss aber nicht. 
Wird ein optionales Argument nicht angegeben, wird automatisch der Defaultwert benutzt.

Die Dateipfade werden immer relativ zum aktuellen Ordner ausgewertet.
Es ist eine Option vorhanden, sich den Log in der Konsole ausgeben zu lassen oder
in einer Datei abzuspeichern. Diese Logdatei wird dann im aktuellen Verzeichnis gespeichert.
Standardmäßig wird nur angezeigt, ob das Programm erfolgreich durchgelaufen ist oder 
ob ein Fehler aufgetreten ist. 
Bei einem Fehler wird dieser ebenfalls standardmäßig in der Konsole ausgegeben. 