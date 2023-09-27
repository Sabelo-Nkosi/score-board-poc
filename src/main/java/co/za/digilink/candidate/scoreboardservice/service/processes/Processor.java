package co.za.digilink.candidate.scoreboardservice.service.processes;

public abstract class Processor<ID, T> {
    public abstract void process(ID categoryID, T category);

    public abstract void process(T category);
}
