package com.cpc.backend.models;

public class Input {
    private String script;
    private String language;

    public Input(String script, String language) {
        this.script = script;
        this.language = language;
    }

    @Override
    public String toString() {
        return "Input{" +
                "script='" + script + '\'' +
                ", language='" + language + '\'' +
                '}';
    }

    public Input() {
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
