package com.emezon.user.domain.utils;

import com.emezon.user.domain.constants.PaginatedResponseConstraints;
import java.util.List;
import java.util.Map;

public class PaginatedResponseUtils {

    public static int getPageFromMap(Map<String, List<String>> queryParams) {
        try {
            List<String> pageList = queryParams.get("page");
            if (pageList != null && !pageList.isEmpty()) {
                return Integer.parseInt(pageList.get(0)); // Obtener el primer valor de la lista
            }
        } catch (NumberFormatException | NullPointerException e) {
            // En caso de error, retornar el valor por defecto
        }
        return PaginatedResponseConstraints.DEFAULT_PAGE_NUMBER;
    }

    public static int getSizeFromMap(Map<String, List<String>> queryParams) {
        try {
            List<String> sizeList = queryParams.get("size");
            if (sizeList != null && !sizeList.isEmpty()) {
                return Integer.parseInt(sizeList.get(0)); // Obtener el primer valor de la lista
            }
        } catch (NumberFormatException | NullPointerException e) {
            // En caso de error, retornar el valor por defecto
        }
        return PaginatedResponseConstraints.DEFAULT_PAGE_SIZE;
    }

    public static List<String> getSortListFromMap(Map<String, List<String>> queryParams) {
        try {
            List<String> list = queryParams.get("sort");
            return (list != null && !list.isEmpty()) ? list : PaginatedResponseConstraints.DEFAULT_SORT;
        } catch (NullPointerException e) {
            return PaginatedResponseConstraints.DEFAULT_SORT;
        }
    }

    public static PaginatedResponseParams getFromMap(Map<String, List<String>> queryParams) {
        PaginatedResponseParams p = new PaginatedResponseParams();
        p.setPage(getPageFromMap(queryParams));
        p.setSize(getSizeFromMap(queryParams));
        p.setSorting(getSortListFromMap(queryParams));
        return p;
    }

    private PaginatedResponseUtils() {
        throw new IllegalStateException("Utility class");
    }
}