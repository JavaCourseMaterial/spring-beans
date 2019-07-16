package com.example.springbeans.model;

import java.util.List;
import java.util.Objects;

/**
 * This is a simple wrapper class for Spring Bean information.
 */
public class SpringBean {

    String name;
    List<String> aliases;
    String scope;
    String type;
    String resource;
    List<String> dependencies;

    public SpringBean() {

    }

    public SpringBean(String name, List<String> aliases, String scope, String type, String resource, List<String> dependencies) {
        this.name = name;
        this.aliases = aliases;
        this.scope = scope;
        this.type = type;
        this.resource = resource;
        this.dependencies = dependencies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public List<String> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<String> dependencies) {
        this.dependencies = dependencies;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpringBean that = (SpringBean) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(aliases, that.aliases) &&
                Objects.equals(scope, that.scope) &&
                Objects.equals(type, that.type) &&
                Objects.equals(resource, that.resource) &&
                Objects.equals(dependencies, that.dependencies);
    }

    @Override public int hashCode() {
        return Objects.hash(name, aliases, scope, type, resource, dependencies);
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("SpringBean{");
        sb.append("name='").append(name).append('\'');
        sb.append(", aliases=").append(aliases);
        sb.append(", scope='").append(scope).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", resource='").append(resource).append('\'');
        sb.append(", dependencies=").append(dependencies);
        sb.append('}');
        return sb.toString();
    }
}
