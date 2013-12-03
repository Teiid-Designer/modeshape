package org.modeshape.jcr.cache.change;

import java.util.Set;
import org.modeshape.jcr.cache.NodeKey;
import org.modeshape.jcr.value.Name;
import org.modeshape.jcr.value.Path;

/**
 * A change event which is generated by a {@link javax.jcr.Node#orderBefore(String, String)} operation.
 * 
 * @author Horia Chiorean
 */
public class NodeReordered extends AbstractNodeChange {

    private static final long serialVersionUID = 1L;

    private final Path oldPath;
    private final NodeKey parent;
    private final Path reorderedBeforePath;

    public NodeReordered( NodeKey key,
                          Name primaryType,
                          Set<Name> mixinTypes,
                          NodeKey parent,
                          Path newPath,
                          Path oldPath,
                          Path reorderedBeforePath ) {
        super(key, newPath, primaryType, mixinTypes);
        this.oldPath = oldPath;
        this.parent = parent;
        this.reorderedBeforePath = reorderedBeforePath;
    }

    public Path getOldPath() {
        return oldPath;
    }

    public NodeKey getParent() {
        return parent;
    }

    /**
     * Gets the path of the node at the "destination" of the reordering.
     * 
     * @return either a node path or <code>null</code>, in case a reordering has happened at the end of the children list
     */
    public Path getReorderedBeforePath() {
        return reorderedBeforePath;
    }
}
