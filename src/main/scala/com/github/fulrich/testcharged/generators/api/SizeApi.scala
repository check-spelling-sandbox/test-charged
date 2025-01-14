package com.github.fulrich.testcharged.generators.api


trait SizeApi[T] {
  def tiny: T
  def small: T
  def default: T
  def large: T
  def huge: T
}
