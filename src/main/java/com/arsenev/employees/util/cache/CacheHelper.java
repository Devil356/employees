package com.arsenev.employees.util.cache;

import java.util.Objects;

public class CacheHelper {
    public static DatatableRequest getDatatableRequest(Integer start, Integer length){
        return new DatatableRequest(start, length);
    }

    public static class DatatableRequest {
        private final Integer start;
        private final Integer length;

        public DatatableRequest(Integer start, Integer length) {
            this.start = start;
            this.length = length;
        }


        public Integer getStart() {
            return start;
        }


        public Integer getLength() {
            return length;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DatatableRequest that = (DatatableRequest) o;
            return Objects.equals(start, that.start) && Objects.equals(length, that.length);
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, length);
        }
    }
}
