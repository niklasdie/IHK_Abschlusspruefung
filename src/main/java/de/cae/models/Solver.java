package de.cae.models;

import de.cae.interfaces.IInput;
import de.cae.interfaces.IOutput;
import de.cae.interfaces.IProcess;

public class Solver implements IProcess<String, String> {

    private String data;

    @Override
    public void done() {

    }

    @Override
    public IProcess<String, String> input(IInput<String> IInput) {
        this.data = IInput.readInFile();
        return this;
    }

    @Override
    public IProcess<String, String> process() {
        this.data = this.data.replaceAll("123", "ABC");
        return this;
    }

    @Override
    public IProcess<String, String> output(IOutput<String> IOutput) {
        IOutput.writeToFile(this.data);
        return this;
    }
}
