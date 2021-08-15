package web.app.TechStore.TechStore.DomainModels;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Memory {
    private long memoryId;
    private String ram;
    private String internalMemory;
    private String memoryCardSupport;
    private String memoryCardMaximumSize;
    private String typeOfMemoryCard;

    @Id
    @Column(name = "memoryID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getMemoryId() {
        return memoryId;
    }

    public void setMemoryId(long memoryId) {
        this.memoryId = memoryId;
    }

    @Basic
    @Column(name = "ram", nullable = true, length = 64)
    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    @Basic
    @Column(name = "internal_memory", nullable = true, length = 64)
    public String getInternalMemory() {
        return internalMemory;
    }

    public void setInternalMemory(String internalMemory) {
        this.internalMemory = internalMemory;
    }

    @Basic
    @Column(name = "memory_card_support", nullable = true, length = 64)
    public String getMemoryCardSupport() {
        return memoryCardSupport;
    }

    public void setMemoryCardSupport(String memoryCardSupport) {
        this.memoryCardSupport = memoryCardSupport;
    }

    @Basic
    @Column(name = "memory_card_maximum_size", nullable = true, length = 64)
    public String getMemoryCardMaximumSize() {
        return memoryCardMaximumSize;
    }

    public void setMemoryCardMaximumSize(String memoryCardMaximumSize) {
        this.memoryCardMaximumSize = memoryCardMaximumSize;
    }

    @Basic
    @Column(name = "type_of_memory_card", nullable = true, length = 64)
    public String getTypeOfMemoryCard() {
        return typeOfMemoryCard;
    }

    public void setTypeOfMemoryCard(String typeOfMemoryCard) {
        this.typeOfMemoryCard = typeOfMemoryCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Memory memory = (Memory) o;
        return memoryId == memory.memoryId && Objects.equals(ram, memory.ram) && Objects.equals(internalMemory, memory.internalMemory) && Objects.equals(memoryCardSupport, memory.memoryCardSupport) && Objects.equals(memoryCardMaximumSize, memory.memoryCardMaximumSize) && Objects.equals(typeOfMemoryCard, memory.typeOfMemoryCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memoryId, ram, internalMemory, memoryCardSupport, memoryCardMaximumSize, typeOfMemoryCard);
    }
}
