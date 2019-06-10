package life.generator;

import life.model.Map;

public interface Generator {
    Map nextMap(Map current);
}
