SOURCEFILES = $(shell find ./src -name '*.java')

.PHONY = all doc cls clean

all: agricole.jar guerre.jar

doc:
	javadoc game -sourcepath ./src -subpackages game -d ./doc -private

agricole.jar: ./classes/MainAgricolGame.class
	jar cvfe ./jar/agricole.jar game.MainAgricolGame -C ./classes .

classes/MainAgricolGame.class:
	javac -sourcepath ./src -d ./classes src/game/MainAgricolGame.java

guerre.jar: ./classes/MainWarGame.class
	jar cvfe ./jar/guerre.jar game.MainWarGame -C ./classes .

classes/MainWarGame.class:
	javac -sourcepath ./src -d ./classes src/game/MainWarGame.java

cls:
	javac $(SOURCEFILES) -d ./classes

clean:
	rm -f ./jar/*.jar
	rm -rf ./doc
	rm -rf ./classes/*
	find ./tests -name '*.class' -delete
