package com.training;

import java.util.ArrayList;
import java.util.List;

public class FirstProvider {

  // example data, change if you like
  public static List<First> createInitialModel() {
    ArrayList<First> list = new ArrayList<First>();
    list.add(createFirst("SWT", "Learn Widgets"));
    list.add(createFirst("JFace", "Especially Viewers!"));
    list.add(createFirst("DI", "@Inject looks interesting"));
    list.add(createFirst("OSGi", "Services"));
    list.add(createFirst("Compatibility Layer", "Run Eclipse 3.x"));
    return list;
  }

  private static First createFirst(String summary, String description) {
    return new First();
  }
} 