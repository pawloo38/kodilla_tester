/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example.utilities

import groovy.transform.PackageScope
import org.example.list.LinkedList

@PackageScope
class JoinUtils {
    static String join(LinkedList source) {
        StringBuilder result = new StringBuilder()
        for (int i = 0; i < source.size(); ++i) {
            if (result.length() > 0) {
                result.append(' ')
            }
            result.append(source.get(i))
        }

        return result.toString()
    }
}
/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example.utilities

import groovy.transform.PackageScope
import org.example.list.LinkedList

@PackageScope
class JoinUtils {
    static String join(LinkedList source) {
        StringBuilder result = new StringBuilder()
        for (int i = 0; i < source.size(); ++i) {
            if (result.length() > 0) {
                result.append(' ')
            }
            result.append(source.get(i))
        }

        return result.toString()
    }
}
