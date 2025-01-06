package org.intermine.model.bio;

public interface Strain extends org.intermine.model.bio.BioEntity
{
    public java.lang.String getAnnotationVersion();
    public void setAnnotationVersion(final java.lang.String annotationVersion);

    public java.lang.String getAssemblyVersion();
    public void setAssemblyVersion(final java.lang.String assemblyVersion);

    public java.util.Set<org.intermine.model.bio.SequenceFeature> getFeatures();
    public void setFeatures(final java.util.Set<org.intermine.model.bio.SequenceFeature> features);
    public void addFeatures(final org.intermine.model.bio.SequenceFeature arg);

}
