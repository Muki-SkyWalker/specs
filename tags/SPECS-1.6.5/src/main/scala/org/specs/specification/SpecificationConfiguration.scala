/**
 * Copyright (c) 2007-2010 Eric Torreborre <etorreborre@yahoo.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of
 * the Software. Neither the name of specs nor the names of its contributors may be used to endorse or promote
 * products derived from this software without specific prior written permission.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */
package org.specs.specification

import org.specs.util.Configuration

/**
 * This trait defines some optional behaviour for a specification such as executing examples in a copy of the specification
 * to be isolated from any other example modifying local variables.
 */
trait SpecificationConfiguration {
  /** get the configuration state */
  private[specification] var oneSpecInstancePerExample = Configuration.config.oneSpecInstancePerExample
  /** 
   * use this method to use the same specification object to execute Examples, effectively sharing
   * variables between them. 
   */
  def shareVariables() = oneSpecInstancePerExample = false
  /** 
   * use this method *not* to use the same specification object to execute Examples, effectively *not* sharing
   * variables between them. 
   */
  def dontShareVariables() = oneSpecInstancePerExample = true
}