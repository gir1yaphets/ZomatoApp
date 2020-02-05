package com.example.zomatoapp.dataModel;

import java.util.List;

public class CategoryListModel {
    private List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public static class Category {
        /**
         * categories : {"id":1,"name":"Delivery"}
         */

        private CategoryModel categories;

        public CategoryModel getCategories() {
            return categories;
        }

        public void setCategories(CategoryModel categories) {
            this.categories = categories;
        }
    }
}
