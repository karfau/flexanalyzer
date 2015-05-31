Aus Interesse am Thema TestDrivenDevelopment (TDD) soll das PlugIn testgetrieben
entwickelt werden. Die Erfahrung und Vorgehensweise mit TDD soll zum Umfang der
Dokumentation und Präsentation des Projekts gehören.
Zum Testen wird SWTBot (End-to-End-Tests) und JUnit verwendet.
Die „Adobe® Flash® Builder™ 4 Extensibility API“ bietet mit dem „Code Model“ (FB-CM) die
Möglichkeit, durch vorhandenen ActionScript-/MXML-Code zu navigieren, ähnlich wie durch
ein DOM-Dokument. Die, für die im Folgenden beschriebenen Features, vom FB-CM
benötigte Funktionalität ist grundlegend konzeptionell getestet/vorhanden.
Dies wollen wir nutzen, um dem Entwickler eine View anzubieten, die für eine auswählbare
Funktion (/einem Funktionsaufruf) eine Ausführungssequenz (logisch wie UMLSequenzdiagramm)
als Baumansicht mit Analysemöglichkeiten liefert.